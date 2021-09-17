package com.pluralsight.resource;

import com.pluralsight.model.Comment;
import com.pluralsight.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getAllComments(
            @PathParam("messageId") long messageId
    ) {
        return commentService.getAllComments(messageId);
    }

    @GET
    @Path("{commentId}")
    public Comment getCommentByMessageId(
            @PathParam("commentId") long commentId,
            @PathParam("messageId") long messageId
    ) {
        return commentService.getComment(messageId, commentId);
    }

    @POST
    public Comment addCommentByMessageId(
            @PathParam("messageId") long messageId,
            Comment comment
    ) {
        return commentService.addComment(messageId,comment);
    }

    @PUT
    public Comment updateCommentByMessageId(
            @PathParam("commentId") long commentId,
            @PathParam("messageId") long messageId,
            Comment comment
    ) {
        comment.setId(commentId);
        return commentService.addComment(messageId,comment);
    }

    @DELETE
    public Comment removeCommentByMessageId(
            @PathParam("commentId") long commentId,
            @PathParam("messageId") long messageId
    ) {
        return commentService.removeComment(messageId, commentId);
    }

}
