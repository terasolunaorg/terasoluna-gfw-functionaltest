/*
 * Copyright(c) 2024 NTT DATA Group Corporation.
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

@Controller
@RequestMapping(value = "message")
public class MessageController {

    @GetMapping
    public String index() {
        return "message/index";
    }

    @GetMapping(value = "1_1")
    public String defaultSpecified_01_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_2")
    public String defaultSpecified_01_02(Model model) {

        model.addAttribute(ResultMessages.success().addAll(ResultMessage.fromCode("i.gt.me.0001"),
                ResultMessage.fromCode("i.gt.me.0002")));

        return "message/default";
    }

    @GetMapping(value = "1_3")
    public String defaultSpecified_01_03(Model model) {

        model.addAttribute(ResultMessages.error().add(ResultMessage.fromText("Error Message!!")));

        return "message/default";
    }

    @GetMapping(value = "1_4")
    public String defaultSpecified_01_04(Model model) {

        model.addAttribute(ResultMessages.info().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_5")
    public String defaultSpecified_01_05(Model model) {

        model.addAttribute(ResultMessages.warning().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_6")
    public String defaultSpecified_01_06(Model model) {

        model.addAttribute(ResultMessages.error().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_7")
    public String defaultSpecified_01_07(Model model) {

        model.addAttribute(ResultMessages.danger().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_8")
    public String defaultSpecified_01_08(Model model) {

        model.addAttribute(ResultMessages.primary().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_9")
    public String defaultSpecified_01_09(Model model) {

        model.addAttribute(ResultMessages.secondary().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_10")
    public String defaultSpecified_01_10(Model model) {

        model.addAttribute(ResultMessages.light().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_11")
    public String defaultSpecified_01_11(Model model) {

        model.addAttribute(ResultMessages.dark().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_12")
    public String defaultSpecified_01_12(Model model) {

        throw new BusinessException(
                ResultMessages.error().add(ResultMessage.fromText("Error Message!!")));
    }

    @GetMapping(value = "1_13")
    public String defaultSpecified_01_13(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/default";
    }

    @GetMapping(value = "1_14")
    public String defaultSpecified_01_14(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0005", "Terasoluna"));

        return "message/default";
    }

    @GetMapping(value = "1_15")
    public String defaultSpecified_01_15(Model model) {

        model.addAttribute(
                ResultMessages.success().add(ResultMessage.fromCode("i.gt.me.0005", "Terasoluna")));

        return "message/default";
    }

    @GetMapping(value = "1_16")
    public String defaultSpecified_01_16(Model model) {

        ResultMessage resultMessage = new ResultMessage("i.gt.me.0001", null, "Terasoluna !!");

        model.addAttribute(ResultMessages.success().add(resultMessage));

        return "message/default";
    }

    @GetMapping(value = "1_17")
    public String defaultSpecified_01_17(Model model) {

        ResultMessage resultMessage = new ResultMessage("i.gt.me.9999", null, "Terasoluna !!");

        model.addAttribute(ResultMessages.success().add(resultMessage));

        return "message/default";
    }

    @GetMapping(value = "2_1")
    public String messagesAttributeNameSpecified_02_01(Model model) {

        model.addAttribute("successMessage", ResultMessages.success().add("i.gt.me.0001"));

        return "message/messagesAttributeName";
    }

    @GetMapping(value = "2_2")
    public String messagesAttributeNameSpecified_02_02(Model model) {

        model.addAttribute("errorMessage",
                ResultMessages.error().add(ResultMessage.fromText("Error Message!!")));

        return "message/messagesAttributeNameStringSpecified";
    }

    @GetMapping(value = "2_3")
    public String messagesAttributeNameSpecified_02_03(Model model) {

        model.addAttribute("successMessage", ResultMessages.success().add("i.gt.me.0001"));

        return "message/messagesAttributeNameSingleSpecified";
    }

    @GetMapping(value = "2_4")
    public String messagesAttributeNameSpecified_02_04(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        resultMessageList.add(ResultMessage.fromCode("i.gt.me.0001"));
        resultMessageList.add(ResultMessage.fromCode("i.gt.me.0002"));
        model.addAttribute("successMessages", ResultMessages.success().addAll(resultMessageList));

        return "message/messagesAttributeNameMultiSpecified";
    }

    @GetMapping(value = "3_1")
    public String elementSpecified_03_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/elementSpecified";
    }

    @GetMapping(value = "3_2")
    public String elementSpecified_03_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelElementSpecified";
    }

    @GetMapping(value = "3_3")
    public String elementSpecified_03_03(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/outerElementSpecified";
    }

    @GetMapping(value = "3_4")
    public String elementSpecified_03_04(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/innerElementSpecified";
    }

    @GetMapping(value = "3_5")
    public String elementSpecified_03_05(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/allElementBlnakSpecified";
    }

    @GetMapping(value = "4_1")
    public String panelClassSpecified_04_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelClassSpecified";
    }

    @GetMapping(value = "4_2")
    public String panelClassSpecified_04_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/panelClassBlankSpecified";
    }

    @GetMapping(value = "5_1")
    public String messagesTypeSpecified_05_01(Model model) {

        model.addAttribute("login_error_message",
                ResultMessages.warning().add(ResultMessage.fromText("Warn Message!!")));

        return "message/messageTypeSpecified";
    }

    @GetMapping(value = "5_2")
    public String messagesTypeSpecified_05_02(Model model) {

        model.addAttribute("login_error_message", ResultMessages.error().add("w.gt.me.0001"));

        return "message/messageTypeSpecified";
    }

    @GetMapping(value = "5_3")
    public String messagesTypeSpecified_05_03(Model model) {

        model.addAttribute("login_error_messages", ResultMessages.error().addAll(
                ResultMessage.fromCode("w.gt.me.0001"), ResultMessage.fromCode("e.gt.me.0001")));

        return "message/messagesTypeSpecified";
    }

    @GetMapping(value = "6_1")
    public String customResultMessageTypeImpl_06_01(Model model) {

        model.addAttribute(
                new ResultMessages(BlueprintResultMessageType.NOTICE).add("w.gt.me.0002"));

        return "message/resultMessageType";
    }

    @GetMapping(value = "6_2")
    public String customResultMessageTypeImpl_06_02(Model model) {

        model.addAttribute(
                new ResultMessages(BlueprintResultMessageType.ERROR).add("e.gt.me.0002"));

        return "message/resultMessageType";
    }

    @GetMapping(value = "6_3")
    public String customResultMessageTypeImpl_06_03(Model model) {

        model.addAttribute(
                new ResultMessages(BlueprintResultMessageType.SUCCESS).add("i.gt.me.0003"));

        return "message/resultMessageType";
    }

    @GetMapping(value = "6_4")
    public String customResultMessageTypeImpl_06_04(Model model) {

        model.addAttribute(new ResultMessages(BlueprintResultMessageType.INFO).add("i.gt.me.0004"));

        return "message/resultMessageType";
    }

    @GetMapping(value = "7_1")
    public String outputMessage_07_01(Model model) {

        model.addAttribute(ResultMessages.success().addAll(ResultMessage.fromText("Hello World!!"),
                ResultMessage.fromText("Hello Message!!")));

        return "message/outputMessage";
    }

    @GetMapping(value = "7_2")
    public String outputMessage_07_02(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.9999"));

    }

    @GetMapping(value = "7_3")
    public String outputMessage_07_03(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.0001"));
    }

    @GetMapping(value = "7_4")
    public String outputMessage_07_04(Model model) {

        throw new BusinessException(ResultMessages.error().add("e.gt.me.0001"));
    }

    @GetMapping(value = "7_5")
    public String outputMessage_07_05(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));
        model.addAttribute("error_message", ResultMessages.error().add("e.gt.me.0001"));

        return "message/outputMessageMultiSpecified";
    }

    @GetMapping(value = "8_1")
    public String styleChangeScreen_08_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0001"));

        return "message/styleChangeScreen";
    }

    @GetMapping(value = "9_1")
    public String disableHtmlEscape_09_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0006"));

        return "message/disableHtmlEscapeNotSpecified";
    }

    @GetMapping(value = "9_2")
    public String disableHtmlEscape_09_02(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0006"));

        return "message/disableHtmlEscapeSpecifiedTrue";
    }

    @GetMapping(value = "10_1")
    public String tagConfiguration_10_01(Model model) {

        model.addAttribute(ResultMessages.success().add("i.gt.me.0007"));

        return "message/tagConfiguration";
    }

    @GetMapping(value = "10_2")
    public String tagConfiguration_10_02(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        model.addAttribute(ResultMessages.success().addAll(resultMessageList));

        return "message/tagConfiguration";
    }

    @GetMapping(value = "10_3")
    public String tagConfiguration_10_03(Model model) {

        List<ResultMessage> resultMessageList = new ArrayList<ResultMessage>();
        model.addAttribute(ResultMessages.success().addAll(resultMessageList));

        return "message/tagConfigurationPanelElement";
    }

}
