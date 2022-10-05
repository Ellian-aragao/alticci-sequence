package ellian.aragao.com.github.domain.usecase.impl;

import ellian.aragao.com.github.domain.exception.IndexOutOfBoundsDomainException;
import ellian.aragao.com.github.domain.model.AlticciTerm;
import ellian.aragao.com.github.domain.repository.AlticciSequenceCacheRepository;
import ellian.aragao.com.github.domain.usecase.AlticciSequenceUsecase;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AlticciSequenceUsecaseImpl implements AlticciSequenceUsecase {

    private final AlticciSequenceCacheRepository cacheRepository;

    @Inject
    public AlticciSequenceUsecaseImpl(AlticciSequenceCacheRepository cacheRepository) {
        this.cacheRepository = cacheRepository;
    }

    @PostConstruct
    public void init() {
        cacheRepository.save(0L, 0L);
        cacheRepository.save(1L, 1L);
        cacheRepository.save(2L, 1L);
    }

    @Override
    public AlticciTerm getSequence(Long size) {
        return new AlticciTerm(size, calculateSequence(size));
    }

    private Long calculateSequence(Long size) {
        if (size == 0L) return 0L;
        if (size == 1L || size == 2L) return 1L;
        if (size < 0L) throw new IndexOutOfBoundsDomainException("Size must be greater than 0");
        if (size >= 158) throw new IndexOutOfBoundsDomainException("Size must be less than 158, otherwise it will overflow the Long type");

        return calculateSequenceBoundVerified(size);
    }

    private Long calculateSequenceBoundVerified(Long size) {
        return cacheRepository
                .findFromIndex(size)
                .orElseGet(() -> {
                    var value = calculateSequenceBoundVerified(size - 3) + calculateSequenceBoundVerified(size - 2);
                    cacheRepository.save(size, value);
                    return value;
                });
    }
}
