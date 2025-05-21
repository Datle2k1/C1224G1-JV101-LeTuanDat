package org.example.casestudy.controller;

import org.example.casestudy.model.Customer;
import org.example.casestudy.model.Media;
import org.example.casestudy.service.customer.CustomerService;
import org.example.casestudy.service.media.MediaService;
import org.example.casestudy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/home-page")
class CustomerController {
    private final CustomerService customerService;
    private final MediaService mediaService;
    private final ResourceLoader resourceLoader;

    @Autowired
    public CustomerController(CustomerService customerService,
                              ResourceLoader resourceLoader,
                              MediaService mediaService) {
        this.customerService = customerService;
        this.mediaService = mediaService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("medias",mediaService.getAllMedias());
        return "home";
    }

    @PostMapping("/upload")
    public String handleFileUpload(@RequestPart("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String filename = Paths.get(Objects.requireNonNull(file.getOriginalFilename())).getFileName().toString();
        String saveFileName = UUID.randomUUID() + filename;
        String message = "";
        String error = "";

        if (file.isEmpty()) {
            error = "File is Empty";
        } else {
            Media.MediaType mediaType = Utils.validExtensions(filename.split("\\.")[1]);
            if (mediaType == null){
                error = "Media Extensions Invalid";
            } else {
                try {
                    Path uploadPath = Paths.get(resourceLoader.getResource("classpath:static/media/").getFile().getPath());
                    Files.createDirectories(uploadPath);

                    Path filePath = uploadPath.resolve(saveFileName);
                    file.transferTo(filePath.toFile());

                    //check file is saved
                    File savedFile = filePath.toFile();
                    if (savedFile.exists() && savedFile.length() > 0) {
                        //save to db
                        Media media = new Media();
                        media.setUploadedAt(LocalDateTime.now());
                        media.setUploadedBy(customerService.getCustomerById(1L));
                        media.setType(mediaType);
                        media.setUrl(saveFileName);
                        media.setComments(new ArrayList<>());
                        media.setTags(new HashSet<>());
                        mediaService.saveMedia(media);

                        message = "Tải lên thành công: " + filename.substring(filename.length() - 20);
                    } else {
                        error = "Tải lên thất bại: file không được lưu đúng cách.";
                    }
                } catch (IOException e) {
                    error = e.getMessage();
                }
            }
        }

        if (error.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("notify_color", "green");
        } else {
            redirectAttributes.addFlashAttribute("message", error);
            redirectAttributes.addFlashAttribute("notify_color", "red");
        }

        return "redirect:/home-page";
    }

    @PostMapping("/sign-in")
    @ResponseBody
    public Map<String, Object> handleSignIn(@RequestBody Map<String, String> data, HttpSession session) {
        Customer customer = customerService.getCustomerByEmail(data.get("email"));
        String message = "";
        String error = "";

        if (customer == null) {
            error = "Email Not Exist";
        } else if (!customer.getPassword().equals(data.get("password"))) {
            error = "Password Wrong";
        } else {
            message = customer.getName() + " - Sign In Success";
        }

        Map<String, Object> response = new HashMap<>();

        if (error.isEmpty()) {
            session.setAttribute("message", message);
            session.setAttribute("notify_color", "green");
        } else {
            session.setAttribute("lastEmail", data.get("email"));

            session.setAttribute("message", error);
            session.setAttribute("notify_color", "red");
        }

        return response;
    }

    @PostMapping("/sign-up")
    public String handleSignUp(@RequestPart("email") String email, @RequestPart("password") String password, RedirectAttributes redirectAttributes) {
        String message = "";
        String error = "";

        return "redirect:/home-page";
    }
}