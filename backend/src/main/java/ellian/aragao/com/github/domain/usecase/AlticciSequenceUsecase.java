package ellian.aragao.com.github.domain.usecase;

import ellian.aragao.com.github.domain.model.AlticciTerm;

public interface AlticciSequenceUsecase {
    AlticciTerm getSequence(Long size);
}
