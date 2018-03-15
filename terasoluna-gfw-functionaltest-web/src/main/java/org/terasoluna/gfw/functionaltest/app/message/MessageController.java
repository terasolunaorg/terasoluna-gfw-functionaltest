/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
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
package org.terasoluna.gfw.functionaltest.app.message;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

@Controller
@RequestMapping(value = "message")
public class MessageController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "message/index";
    }

    @RequestMapping(value = "1_1", method = RequestMethod.GET)
    public String defaultSpecified_01_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_2", method = RequestMethod.GET)
    public String defaultSpecified_01_02(Model model) {

        model.addAttribute(ResultMessages.success().addAll(ResultMessage
                .fromCode("i.gt.me.0001"), ResultMessage.fromCode(
                        "i.gt.me.0002")));

        return "message/default";
    }

    @RequestMapping(value = "1_3", method = RequestMethod.GET)
    public String defaultSpecified_01_03(Model model) {

        model.addAttribute(ResultMessages.error().add(ResultMessage.fromText(
                "Error Message!!")));

        return "message/default";
    }

    @RequestMapping(value = "1_4", method = RequestMethod.GET)
    public String defaultSpecified_01_04(Model model) {

        model.addAttribute(ResultMessages.info().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_5_1", method = RequestMethod.GET)
    public String defaultSpecified_01_05_01(Model model) {

        model.addAttribute(ResultMessages.warn().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_5_2", method = RequestMethod.GET)
    public String defaultSpecified_01_05_02(Model model) {

        model.addAttribute(ResultMessages.warning().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_6", method = RequestMethod.GET)
    public String defaultSpecified_01_06(Model model) {

        model.addAttribute(ResultMessages.error().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_7", method = RequestMethod.GET)
    public String defaultSpecified_01_07(Model model) {

        model.addAttribute(ResultMessages.danger().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_8", method = RequestMethod.GET)
    public String defaultSpecified_01_08(Model model) {

        throw new BusinessException(ResultMessages.error().add(ResultMessage
                .fromText("Error Message!!")));
    }

    @RequestMapping(value = "1_9", method = RequestMethod.GET)
    public String defaultSpecified_01_09(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/default";
    }

    @RequestMapping(value = "1_10", method = RequestMethod.GET)
    public String defaultSpecified_01_10(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0005",
                "Terasoluna"));

        return "message/default";
    }

    @RequestMapping(value = "1_11", method = RequestMethod.GET)
    public String defaultSpecified_01_11(Model model) {

        model.addAttribute(ResultMessages.success().add(ResultMessage.fromCode(
                "i.gt.me.0005", "Terasoluna")));

        return "message/default";
    }

    @RequestMapping(value = "1_12", method = RequestMethod.GET)
    public String defaultSpecified_01_12(Model model) {

        ResultMessage resultMessage = new ResultMessage("i.gt.me.0001", null, "Terasoluna !!");

        model.addAttribute(ResultMessages.success().add(resultMessage));

        return "message/default";
    }

    @RequestMapping(value = "1_13", method = RequestMethod.GET)
    public String defaultSpecified_01_13(Model model) {

        ResultMessage resultMessage = new ResultMessage("i.gt.me.9999", null, "Terasoluna !!");

        model.addAttribute(ResultMessages.success().add(resultMessage));

        return "message/default";
    }

    @RequestMapping(value = "2_1", method = RequestMethod.GET)
    public String messagesAttributeNameSpecified_02_01(Model model) {

        model.addAttribute("successMessage", ResultMessages.success().add(
                "i.gt.me.0001"));

        return "message/messagesAttributeName";
    }

    @RequestMapping(value = "2_2", method = RequestMethod.GET)
    public String messagesAttributeNameSpecified_02_02(Model model) {

        model.addAttribute("errorMessage", ResultMessages.error().add(
                ResultMessage.fromText("Error Message!!")));

        return "message/messagesAttributeNameStringSpecified";
    }

    @RequestMapping(value = "2_3", method = RequestMethod.GET)
    public String messagesAttributeNameSpecified_02_03(Model model) {

        model.addAttribute("successMessage", ResultMessages.success().add(
                "i.gt.me.0001"));

        return "message/messagesAttributeNameSingleSpecified";
    }

    @RequestMapping(value = "2_4", method = RequestMethod.GET)
    public String messagesAttributeNameSpecified_02_04(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        resultMessageList.add(ResultMessage.fromCode("i.gt.me.0001"));
        resultMessageList.add(ResultMessage.fromCode("i.gt.me.0002"));
        model.addAttribute("successMessages", ResultMessages.success().addAll(
                resultMessageList));

        return "message/messagesAttributeNameMultiSpecified";
    }

    @RequestMapping(value = "3_1", method = RequestMethod.GET)
    public String elementSpecified_03_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/elementSpecified";
    }

    @RequestMapping(value = "3_2", method = RequestMethod.GET)
    public String elementSpecified_03_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelElementSpecified";
    }

    @RequestMapping(value = "3_3", method = RequestMethod.GET)
    public String elementSpecified_03_03(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/outerElementSpecified";
    }

    @RequestMapping(value = "3_4", method = RequestMethod.GET)
    public String elementSpecified_03_04(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/innerElementSpecified";
    }

    @RequestMapping(value = "3_5", method = RequestMethod.GET)
    public String elementSpecified_03_05(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/allElementBlnakSpecified";
    }

    @RequestMapping(value = "4_1", method = RequestMethod.GET)
    public String panelClassSpecified_04_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelClassSpecified";
    }

    @RequestMapping(value = "4_2", method = RequestMethod.GET)
    public String panelClassSpecified_04_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelClassBlankSpecified";
    }

    @RequestMapping(value = "5_1", method = RequestMethod.GET)
    public String messagesTypeSpecified_05_01(Model model) {

        model.addAttribute("login_error_message", ResultMessages.warning().add(
                ResultMessage.fromText("Warn Message!!")));

        return "message/messageTypeSpecified";
    }

    @RequestMapping(value = "5_2", method = RequestMethod.GET)
    public String messagesTypeSpecified_05_02(Model model) {

        model.addAttribute("login_error_message", ResultMessages.error().add(
                "w.gt.me.0001"));

        return "message/messageTypeSpecified";
    }

    @RequestMapping(value = "5_3", method = RequestMethod.GET)
    public String messagesTypeSpecified_05_03(Model model) {

        model.addAttribute("login_error_messages", ResultMessages.error()
                .addAll(ResultMessage.fromCode("w.gt.me.0001"), ResultMessage
                        .fromCode("e.gt.me.0001")));

        return "message/messagesTypeSpecified";
    }

    @RequestMapping(value = "6_1", method = RequestMethod.GET)
    public String customResultMessageTypeImpl_06_01(Model model) {

        model.addAttribute(new ResultMessages(BlueprintResultMessageType.NOTICE)
                .add("w.gt.me.0002"));

        return "message/resultMessageType";
    }

    @RequestMapping(value = "6_2", method = RequestMethod.GET)
    public String customResultMessageTypeImpl_06_02(Model model) {

        model.addAttribute(new ResultMessages(BlueprintResultMessageType.ERROR)
                .add("e.gt.me.0002"));

        return "message/resultMessageType";
    }

    @RequestMapping(value = "6_3", method = RequestMethod.GET)
    public String customResultMessageTypeImpl_06_03(Model model) {

        model.addAttribute(
                new ResultMessages(BlueprintResultMessageType.SUCCESS).add(
                        "i.gt.me.0003"));

        return "message/resultMessageType";
    }

    @RequestMapping(value = "6_4", method = RequestMethod.GET)
    public String customResultMessageTypeImpl_06_04(Model model) {

        model.addAttribute(new ResultMessages(BlueprintResultMessageType.INFO)
                .add("i.gt.me.0004"));

        return "message/resultMessageType";
    }

    @RequestMapping(value = "7_1", method = RequestMethod.GET)
    public String outputMessage_07_01(Model model) {

        model.addAttribute(ResultMessages.success().addAll(ResultMessage
                .fromText("Hello World!!"), ResultMessage.fromText(
                        "Hello Message!!")));

        return "message/outputMessage";
    }

    @RequestMapping(value = "7_2", method = RequestMethod.GET)
    public String outputMessage_07_02(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.9999"));

    }

    @RequestMapping(value = "7_3", method = RequestMethod.GET)
    public String outputMessage_07_03(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.0001"));
    }

    @RequestMapping(value = "7_4", method = RequestMethod.GET)
    public String outputMessage_07_04(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.0001"));
    }

    @RequestMapping(value = "7_5", method = RequestMethod.GET)
    public String outputMessage_07_05(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));
        model.addAttribute("error_message", ResultMessages.error().add(
                "e.gt.me.0001"));

        return "message/outputMessageMultiSpecified";
    }

    @RequestMapping(value = "8_1", method = RequestMethod.GET)
    public String styleChangeScreen_08_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/styleChangeScreen";
    }

    @RequestMapping(value = "9_1", method = RequestMethod.GET)
    public String disableHtmlEscape_09_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0006"));

        return "message/disableHtmlEscapeNotSpecified";
    }

    @RequestMapping(value = "9_2", method = RequestMethod.GET)
    public String disableHtmlEscape_09_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0006"));

        return "message/disableHtmlEscapeSpecifiedTrue";
    }

    @RequestMapping(value = "10_1", method = RequestMethod.GET)
    public String tagConfiguration_10_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0007"));

        return "message/tagConfiguration";
    }

    @RequestMapping(value = "10_2", method = RequestMethod.GET)
    public String tagConfiguration_10_02(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        model.addAttribute(ResultMessages.success().addAll(resultMessageList));

        return "message/tagConfiguration";
    }

    @RequestMapping(value = "10_3", method = RequestMethod.GET)
    public String tagConfiguration_10_03(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        model.addAttribute(ResultMessages.success().addAll(resultMessageList));

        return "message/tagConfigurationPanelElement";
    }

}
