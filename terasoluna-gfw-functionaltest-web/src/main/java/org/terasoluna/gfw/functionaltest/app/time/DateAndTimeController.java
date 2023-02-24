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
package org.terasoluna.gfw.functionaltest.app.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.JapaneseDate;

import org.apache.commons.lang3.ThreadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.time.ClockFactory;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Controller
@RequestMapping(value = "time")
public class DateAndTimeController {

    @Inject
    @Named("defaultClockFactory")
    protected ClockFactory defaultClockFactory;

    @Inject
    @Named("defaultConfigurableClockFactory")
    protected ClockFactory defaultConfigurableClockFactory;

    @Inject
    @Named("patternConfigurableClockFactory")
    protected ClockFactory patternConfigurableClockFactory;

    @Inject
    @Named("dateAndTimeConfigurableClockFactory")
    protected ClockFactory dateAndTimeConfigurableClockFactory;
    
    @Inject
    @Named("configurableAdjustClockFactory")
    protected ClockFactory configurableAdjustClockFactory;
    
    @Inject
    @Named("defaultJdbcClockFactory")
    protected ClockFactory jdbcClockFactory;
    
    @Inject
    @Named("adjustJdbcClockFactory")
    protected ClockFactory jdbcAdjustClockFactory;
    
    // CST : America/Chicago : Time difference 15 hours
    private static final ZoneId CST = ZoneId.of(ZoneId.SHORT_IDS.get("CST"));

    @GetMapping
    public String index() {
        return "time/index";
    }

    @GetMapping(value = "1_1")
    public String serverTimeReturn_01_01(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.defaultClockFactory.fixed();
        Clock fixedChangeZoneClock = this.defaultClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.defaultClockFactory.tick();
        Clock tickChangeZoneClock = this.defaultClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }
    
    @GetMapping(value = "2_1")
    public String serverTimeReturn_02_01(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.defaultConfigurableClockFactory.fixed();
        Clock fixedChangeZoneClock = this.defaultConfigurableClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.defaultConfigurableClockFactory.tick();
        Clock tickChangeZoneClock = this.defaultConfigurableClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }

    @GetMapping(value = "2_2")
    public String serverTimeReturn_02_02(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.patternConfigurableClockFactory.fixed();
        Clock fixedChangeZoneClock = this.patternConfigurableClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.patternConfigurableClockFactory.tick();
        Clock tickChangeZoneClock = this.patternConfigurableClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }

    @GetMapping(value = "2_3")
    public String serverTimeReturn_02_03(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.dateAndTimeConfigurableClockFactory.fixed();
        Clock fixedChangeZoneClock = this.dateAndTimeConfigurableClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.dateAndTimeConfigurableClockFactory.tick();
        Clock tickChangeZoneClock = this.dateAndTimeConfigurableClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }

    @GetMapping(value = "3_1")
    public String serverTimeReturn_03_01(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.configurableAdjustClockFactory.fixed();
        Clock fixedChangeZoneClock = this.configurableAdjustClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.configurableAdjustClockFactory.tick();
        Clock tickChangeZoneClock = this.configurableAdjustClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }
    
    @GetMapping(value = "4_1")
    public String serverTimeReturn_04_01(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.jdbcClockFactory.fixed();
        Clock fixedChangeZoneClock = this.jdbcClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.jdbcClockFactory.tick();
        Clock tickChangeZoneClock = this.jdbcClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }
    
    @GetMapping(value = "5_1")
    public String serverTimeReturn_05_01(Model model) throws Exception {

        Clock fixedDefaultZoneClock = this.jdbcAdjustClockFactory.fixed();
        Clock fixedChangeZoneClock = this.jdbcAdjustClockFactory.fixed(CST);
        Clock tickDefaultZoneClock = this.jdbcAdjustClockFactory.tick();
        Clock tickChangeZoneClock = this.jdbcAdjustClockFactory.tick(CST);

        setAttribute(model, fixedDefaultZoneClock, tickDefaultZoneClock,
                fixedChangeZoneClock, tickChangeZoneClock);
        
        return "time/dateAndTimeDisplay";
    }
    
    private void setAttribute(Model model, Clock fixedDefaultZoneClock,
            Clock tickDefaultZoneClock, Clock fixedChangeZoneClock,
            Clock tickChangeZoneClock) throws InterruptedException {

        model.addAttribute("now", LocalDateTime.now(Clock.systemDefaultZone()));
        model.addAttribute("defaultZomeId", ZoneId.systemDefault());
        model.addAttribute("changeZoneId", CST.getId());
        
        // fixedDefaultZone
        model.addAttribute("fixedDefaultZoneInstant", Instant.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneLocalDateTime", LocalDateTime.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneLocalDate", LocalDate.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneLocalTime", LocalTime.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneOffsetDateTime", OffsetDateTime.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneOffsetTime", OffsetTime.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZonedDateTime", ZonedDateTime.now(
                fixedDefaultZoneClock));
        model.addAttribute("fixedDefaultZoneJapaneseDate", JapaneseDate.now(
                fixedDefaultZoneClock));
        
        // fixedChangeZone
        model.addAttribute("fixedChangeZoneInstant", Instant.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneLocalDateTime", LocalDateTime.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneLocalDate", LocalDate.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneLocalTime", LocalTime.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneOffsetDateTime", OffsetDateTime.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneOffsetTime", OffsetTime.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneZonedDateTime", ZonedDateTime.now(
                fixedChangeZoneClock));
        model.addAttribute("fixedChangeZoneJapaneseDate", JapaneseDate.now(
                fixedChangeZoneClock));

        // To make the difference between ticks easier to see, wait 1 second
        ThreadUtils.sleep(Duration.ofSeconds(1L));

        // tickDefaultZone
        model.addAttribute("tickDefaultZoneInstant", Instant.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneLocalDateTime", LocalDateTime.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneLocalDate", LocalDate.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneLocalTime", LocalTime.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneOffsetDateTime", OffsetDateTime.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneOffsetTime", OffsetTime.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZonedDateTime", ZonedDateTime.now(
                tickDefaultZoneClock));
        model.addAttribute("tickDefaultZoneJapaneseDate", JapaneseDate.now(
                tickDefaultZoneClock));

        // ftickChangeZone
        model.addAttribute("tickChangeZoneInstant", Instant.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneLocalDateTime", LocalDateTime.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneLocalDate", LocalDate.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneLocalTime", LocalTime.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneOffsetDateTime", OffsetDateTime.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneOffsetTime", OffsetTime.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneZonedDateTime", ZonedDateTime.now(
                tickChangeZoneClock));
        model.addAttribute("tickChangeZoneJapaneseDate", JapaneseDate.now(
                tickChangeZoneClock));
    }
}
