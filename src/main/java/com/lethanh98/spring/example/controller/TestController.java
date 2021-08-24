package com.lethanh98.spring.example.controller;

import com.google.common.util.concurrent.ListenableFuture;
import com.lethanh98.spring.example.reponse.UsersRP;
import com.lethanh98.spring.example.service.clazz.TransactionOnClass;
import com.lethanh98.spring.example.service.clazz.TransactionOnClassMethodOverride;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@Slf4j
@RequestMapping(value = "/api/test")
@AllArgsConstructor
public class TestController extends BaseResource {


    private final TransactionOnClass transactionOnClass;
    private final TransactionOnClassMethodOverride transactionOnClassMethodOverride;

    @GetMapping(value = "Transaction_On_Class")
    public DeferredResult<?> get() {
        ListenableFuture<?> future = asyncExecute(() -> {
            transactionOnClass.rootMethod();
            return new UsersRP();
        });
        return callBackResponse(future);

    }

    @GetMapping(value = "Transaction_On_Class_Method_Override")
    public DeferredResult<?> get2() {
        ListenableFuture<?> future = asyncExecute(() -> {
            transactionOnClassMethodOverride.rootMethod();
            return new UsersRP();
        });
        return callBackResponse(future);

    }

}
