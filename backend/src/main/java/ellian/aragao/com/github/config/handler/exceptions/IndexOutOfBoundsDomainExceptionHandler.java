package ellian.aragao.com.github.config.handler.exceptions;

import ellian.aragao.com.github.domain.exception.IndexOutOfBoundsDomainException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IndexOutOfBoundsDomainExceptionHandler implements ExceptionMapper<IndexOutOfBoundsDomainException> {

    @Override
    public Response toResponse(IndexOutOfBoundsDomainException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.TEXT_PLAIN_TYPE)
                .entity(e.getMessage())
                .build();
    }
}
