package com.lethanh98.spring.example.service.clazz;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@Slf4j
@Transactional
@AllArgsConstructor
// Khi khai báo Transactional trên class.
// Tất cả method là public khi khi được gọi từ bên ngoài thì đều sẽ tạo và sử dụng config transaction của class.
public class TransactionOnClass {

    public void rootMethod() {
        log.info(TransactionSynchronizationManager.isSynchronizationActive() + "");
        log.info(TransactionSynchronizationManager.getCurrentTransactionName());
        subMethod1();
    }

    private void subMethod1() {
        log.info(TransactionSynchronizationManager.isSynchronizationActive() + "");
        log.info("Transaction name: " + TransactionSynchronizationManager.getCurrentTransactionName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
