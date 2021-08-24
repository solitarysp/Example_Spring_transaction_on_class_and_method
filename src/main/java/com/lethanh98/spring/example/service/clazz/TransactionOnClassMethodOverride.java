package com.lethanh98.spring.example.service.clazz;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
public class TransactionOnClassMethodOverride {

    // nếu chúng ta config Transactional ở trên method. Transactional ở trên method sẽ overriding Transactional trên class
    // Khi đó config Transactional ở trên method sẽ được sử dụng
    @Transactional(propagation = Propagation.MANDATORY)
    public void rootMethod() {
        log.info(TransactionSynchronizationManager.isSynchronizationActive() + "");
        log.info(TransactionSynchronizationManager.getCurrentTransactionName());
    }

}
