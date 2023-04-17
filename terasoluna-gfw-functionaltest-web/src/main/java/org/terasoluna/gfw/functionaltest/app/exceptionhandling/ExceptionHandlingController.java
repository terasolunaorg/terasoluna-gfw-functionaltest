/*
 * Copyright(c) 2013 NTT DATA Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.functionaltest.app.exceptionhandling;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.exception.SystemException;
import org.terasoluna.gfw.common.message.ResultMessages;
import org.terasoluna.gfw.functionaltest.domain.exception.BusinessMessageException;
import org.terasoluna.gfw.functionaltest.domain.exception.BusinessTestException;
import org.terasoluna.gfw.functionaltest.domain.exception.ContinueException;
import org.terasoluna.gfw.functionaltest.domain.exception.ExceptionLoggerDefaultException;
import org.terasoluna.gfw.functionaltest.domain.exception.MultipleChoicesException;
import org.terasoluna.gfw.functionaltest.domain.exception.NormalException;
import org.terasoluna.gfw.functionaltest.domain.service.exceptionhandling.ExceptionHandlingService;
import org.terasoluna.gfw.functionaltest.domain.service.exceptionhandling.InfoLoggingExceptionHandlingService;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenCheck;
import org.terasoluna.gfw.web.token.transaction.TransactionTokenType;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;

@Controller
@TransactionTokenCheck("exceptionhandling")
@RequestMapping(value = "exceptionhandling")
public class ExceptionHandlingController {

    @Inject
    protected ExceptionHandlingService exceptionHandlingService;

    @Inject
    protected InfoLoggingExceptionHandlingService infoLoggingExceptionHandlingService;

    @GetMapping
    public String index() {
        return "exceptionhandling/index";
    }

    @GetMapping(value = "1_1")
    public String requestControllerHandling_01_01(Model model) {

        try {
            exceptionHandlingService.throwException(
                    new BusinessException("Error"));
        } catch (BusinessException be) {
            model.addAttribute(be.getResultMessages());
            return "exceptionhandling/errorOutput";
        } catch (Exception e) {
        }

        return "exceptionhandling/index";
    }

    @GetMapping(value = "1_2")
    public String requestControllerHandling_01_02(Model model) {

        try {
            infoLoggingExceptionHandlingService.throwException(
                    new BusinessException(ResultMessages.info().add(
                            "i.gt.me.0004")));
        } catch (BusinessException be) {
            model.addAttribute(be.getResultMessages());
            return "exceptionhandling/errorOutput";
        } catch (Exception e) {
        }

        return "exceptionhandling/index";
    }

    @GetMapping(value = "2_1")
    public String useCaseControllerHandling_02_01() {

        exceptionHandlingService.throwException(
                new ContinueException("2_1 Continue"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "2_2")
    public String useCaseControllerHandling_02_02() {

        exceptionHandlingService.throwException(new NormalException("2_2 Ok"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "2_3")
    public String useCaseControllerHandling_02_03() {

        exceptionHandlingService.throwException(
                new MultipleChoicesException("2_3 Multiple Choices"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "2_4")
    public String useCaseControllerHandling_02_04() {

        exceptionHandlingService.throwException(
                new OptimisticLockingFailureException("2_4 Conflict"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "2_5")
    public String useCaseControllerHandling_02_05() {

        exceptionHandlingService.throwException(
                new PessimisticLockingFailureException("2_5 ignore logging"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_1")
    public String servletFrameworkHandling_03_01() {

        exceptionHandlingService.throwException(
                new SystemException("i.xx.xxx", "3_1 SystemException"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_2")
    public String servletFrameworkHandling_03_02() {

        exceptionHandlingService.throwException(
                new SystemException("w.xx.xxx", "3_2 SystemException"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_3")
    public String servletFrameworkHandling_03_03() {

        exceptionHandlingService.throwException(
                new SystemException("e.xx.xxx", "3_3 SystemException"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_4")
    public String servletFrameworkHandling_03_04() {

        exceptionHandlingService.throwException(
                new SystemException("e.xx.xxx", "3_4 SystemException", new Throwable("create throwable")));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "exceptionHandlingRedirect/3_4_1")
    public String servletFrameworkHandling_03_04_01() {
        return "common/error/systemError";
    }

    @GetMapping(value = "3_5")
    public String servletFrameworkHandling_03_05() {

        exceptionHandlingService.throwException(
                new BusinessTestException("w.yy.yyy"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_6")
    public String servletFrameworkHandling_03_06() {

        exceptionHandlingService.throwException(
                new BusinessTestException("w.yy.yyy"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_7")
    public String servletFrameworkHandling_03_07() {

        exceptionHandlingService.throwException(
                new ResourceNotFoundException("i.xx.xxx"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_8")
    public String servletFrameworkHandling_03_08() {

        exceptionHandlingService.throwException(
                new QueryTimeoutException("e.cc.ccc"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_9")
    public String servletFrameworkHandling_03_09() {

        exceptionHandlingService.throwException(
                new SystemException("e.xx.xxx", "3_9 Error"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "3_10")
    @TransactionTokenCheck(type = TransactionTokenType.IN)
    public String servletFrameworkHandling_03_10() {
        return "exceptionhandling/index";
    }

    @GetMapping(value = "4_1")
    public String webApplicationHandling_04_01() {

        return "exceptionhandling/viewIOException";
    }

    @GetMapping(value = "4_2")
    public String servletFrameworkHandling_04_2() throws ExceptionHandlingException {

        try {
            exceptionHandlingService.throwAssertionError();
        } catch (Throwable t) {
            throw new ExceptionHandlingException(t);
        }

        return "exceptionhandling/index";
    }

    @GetMapping(value = "4_3")
    public String webApplicationHandling_04_03() {

        return "exceptionhandling/index";
    }

    @GetMapping(value = "4_4")
    public String webApplicationHandling_04_04() {

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_1")
    public String exceptionLoggerVariation_05_01() {

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_2")
    public String exceptionLoggerVariation_05_02() {

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_3")
    public String exceptionLoggerVariation_05_03() {

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_4")
    public String exceptionLoggerVariation_05_04() {

        exceptionHandlingService.throwException(
                new ExceptionLoggerDefaultException());

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_5")
    public String exceptionLoggerVariation_05_05() {

        exceptionHandlingService.throwException(
                new MultipleChoicesException("5_5 Error "));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "5_6")
    public String exceptionLoggerVariation_05_06() {

        exceptionHandlingService.throwException(
                new BusinessMessageException("5_6 Error"));

        return "exceptionhandling/index";
    }

    @GetMapping(value = "6_1")
    public String exceptionOccuresInSharedService_06_01(Model model) {

        try {
            exceptionHandlingService.throwExceptionInSharedServiceNotCatchThis(
                    new BusinessException("Error"));
        } catch (BusinessException be) {
            model.addAttribute(be.getResultMessages());
            return "exceptionhandling/errorOutput";
        } catch (Exception e) {
        }

        return "exceptionhandling/index";
    }

    @GetMapping(value = "6_2")
    public String exceptionOccuresInSharedService_06_02() {

        exceptionHandlingService.throwExceptionInSharedServiceCatchThis(
                new BusinessException("Error"));

        return "exceptionhandling/index";
    }

    @ExceptionHandler(ContinueException.class)
    @ResponseStatus(HttpStatus.CONTINUE)
    public ModelAndView handleException(ContinueException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();

        modelMap.addAttribute("exceptionMessage", e.getMessage());
        return new ModelAndView("exceptionhandling/exceptionHandler", modelMap);
    }

    @ExceptionHandler(NormalException.class)
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView handleException(NormalException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();

        modelMap.addAttribute("exceptionMessage", e.getMessage());
        return new ModelAndView("exceptionhandling/exceptionHandler", modelMap);
    }

    @ExceptionHandler(MultipleChoicesException.class)
    @ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
    public ModelAndView handleException(MultipleChoicesException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();

        modelMap.addAttribute("exceptionMessage", e.getMessage());
        return new ModelAndView("exceptionhandling/exceptionHandler", modelMap);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ModelAndView handleException(OptimisticLockingFailureException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();

        modelMap.addAttribute("exceptionMessage", e.getMessage());
        return new ModelAndView("exceptionhandling/exceptionHandler", modelMap);
    }

    @ExceptionHandler(PessimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ModelAndView handleException(PessimisticLockingFailureException e) {
        ExtendedModelMap modelMap = new ExtendedModelMap();

        modelMap.addAttribute("exceptionMessage", e.getMessage());
        return new ModelAndView("exceptionhandling/exceptionHandler", modelMap);
    }

    public class ExceptionHandlingException extends ServletException {
        private static final long serialVersionUID = 1L;

        public ExceptionHandlingException(Throwable t) {
            super(t);
        }
    }

}
