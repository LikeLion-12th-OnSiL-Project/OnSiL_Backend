package likelion_backend.OnSiL.domain.comment.controller;

import likelion_backend.OnSiL.domain.comment.dto.CommentRequest;
import likelion_backend.OnSiL.domain.comment.entity.Comment;
import likelion_backend.OnSiL.domain.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment createComment(@RequestBody CommentRequest commentRequest, @AuthenticationPrincipal UserDetails userDetails) {
        return commentService.createComment(commentRequest, userDetails.getUsername());
    }

    @DeleteMapping("/{commentId}")
    public String deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetails userDetails) {
        commentService.deleteComment(commentId, userDetails.getUsername());
        return "Comment removed";
    }
}