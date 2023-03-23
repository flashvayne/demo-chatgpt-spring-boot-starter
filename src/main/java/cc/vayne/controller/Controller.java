package cc.vayne.controller;

import cc.vayne.dto.ResponseModel;
import io.github.flashvayne.chatgpt.dto.chat.MultiChatMessage;
import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@CrossOrigin
@RestController
public class Controller {

    @Autowired
    private ChatgptService chatgptService;

    @GetMapping("/send")
    public ResponseModel<String> send(HttpServletRequest request, @RequestParam String message) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), message);
        if (!StringUtils.hasText(message)) {
            return ResponseModel.fail("message can not be blank");
        }
        String responseMessage = chatgptService.sendMessage(message);
        log.info("requestId {}, ip {}, get a reply : {}", requestId, request.getRemoteHost(), responseMessage);
        return ResponseModel.success(responseMessage);
    }

    @PostMapping("/multi/send")
    public ResponseModel<String> multiSend(HttpServletRequest request, @RequestBody List<MultiChatMessage> messages) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, send messages : {}", requestId, request.getRemoteHost(), messages.toString());
        if (CollectionUtils.isEmpty(messages)) {
            return ResponseModel.fail("messages can not be empty");
        }
        String responseMessage = chatgptService.multiChat(messages);
        log.info("requestId {}, ip {}, get a reply : {}", requestId, request.getRemoteHost(), responseMessage);
        return ResponseModel.success(responseMessage);
    }

    @GetMapping("/image")
    public ResponseModel<String> image(HttpServletRequest request, @RequestParam String prompt) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, image generation prompt : {}", requestId, request.getRemoteHost(), prompt);
        if (!StringUtils.hasText(prompt)) {
            return ResponseModel.fail("prompt can not be blank");
        }
        String imageUrl = chatgptService.imageGenerate(prompt);
        log.info("requestId {}, ip {}, image is generated : {}", requestId, request.getRemoteHost(), imageUrl);
        return ResponseModel.success(imageUrl);
    }

    @GetMapping("/images")
    public ResponseModel<List<String>> images(HttpServletRequest request, @RequestParam String prompt,
                                       Integer n, Integer size,String format) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, image generation prompt : {}", requestId, request.getRemoteHost(), prompt);
        ImageSize imageSize;
        switch (size){
            case 1 : imageSize = ImageSize.SMALL; break;
            case 2 : imageSize = ImageSize.MEDIUM; break;
            default: imageSize = ImageSize.LARGE;
        }
        ImageFormat imageFormat = "url".equals(format) ? ImageFormat.URL : ImageFormat.BASE64;
        List<String> images = chatgptService.imageGenerate(prompt,n, imageSize,imageFormat);
        log.info("requestId {}, ip {}, image is generated : {}", requestId, request.getRemoteHost(), images.toString());
        return ResponseModel.success(images);
    }

}