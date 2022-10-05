package ellian.aragao.com.github.infra.entrypoint.http;

import ellian.aragao.com.github.domain.model.AlticciTerm;
import ellian.aragao.com.github.domain.usecase.AlticciSequenceUsecase;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alticci")
public class AlticciSequenceResource {
    private final AlticciSequenceUsecase alticciSequenceUsecase;

    @Inject
    public AlticciSequenceResource(AlticciSequenceUsecase alticciSequenceUsecase) {
        this.alticciSequenceUsecase = alticciSequenceUsecase;
    }

    @GET
    @Path("/{size}")
    @Produces(MediaType.APPLICATION_JSON)
    public AlticciTerm hello(Long size) {
        return alticciSequenceUsecase.getSequence(size);
    }
}
