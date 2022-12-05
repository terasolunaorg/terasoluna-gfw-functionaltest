
<h2>JSR-310 Instance</h2>

<table>
    <tr>
        <td>Now (systemDefaultZone)</td>
        <td id="now">${now}</td>
    </tr>
    <tr>
        <td>defaultZomeId</td>
        <td id="defaultZomeId">${defaultZomeId}</td>
    </tr>
    <tr>
        <td>changeZoneId</td>
        <td id="changeZoneId">${changeZoneId}</td>
    </tr>
</table>

<br>

<table>
    <tr>
        <th>type</th>
        <th>fixed (Default Zone)</th>
        <th>tick (Default Zone)</th>
        <th>fixed (Change Zone)</th>
        <th>tick (Change Zone)</th>
    </tr>
    <tr>
        <td>Instant (uuuu/MM/dd HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZoneInstant"><javatime:format value="${fixedDefaultZoneInstant}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneInstant"><javatime:format value="${tickDefaultZoneInstant}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneInstant"><javatime:format value="${fixedChangeZoneInstant}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneInstant"><javatime:format value="${tickChangeZoneInstant}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>LocalDateTime (uuuu/MM/dd HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZoneLocalDateTime"><javatime:format value="${fixedDefaultZoneLocalDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneLocalDateTime"><javatime:format value="${tickDefaultZoneLocalDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneLocalDateTime"><javatime:format value="${fixedChangeZoneLocalDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneLocalDateTime"><javatime:format value="${tickChangeZoneLocalDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>LocalDate (uuuu/MM/dd)</td>
        <td id="fixedDefaultZoneLocalDate"><javatime:format value="${fixedDefaultZoneLocalDate}" pattern="uuuu/MM/dd" /></td>
        <td id="tickDefaultZoneLocalDate"><javatime:format value="${tickDefaultZoneLocalDate}" pattern="uuuu/MM/dd" /></td>
        <td id="fixedChangeZoneLocalDate"><javatime:format value="${fixedChangeZoneLocalDate}" pattern="uuuu/MM/dd" /></td>
        <td id="tickChangeZoneLocalDate"><javatime:format value="${tickChangeZoneLocalDate}" pattern="uuuu/MM/dd" /></td>
    </tr>
    <tr>
        <td>LocalTime (HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZoneLocalTime"><javatime:format value="${fixedDefaultZoneLocalTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneLocalTime"><javatime:format value="${tickDefaultZoneLocalTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneLocalTime"><javatime:format value="${fixedChangeZoneLocalTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneLocalTime"><javatime:format value="${tickChangeZoneLocalTime}" pattern="HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>OffsetDateTime (uuuu/MM/dd HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZoneOffsetDateTime"><javatime:format value="${fixedDefaultZoneOffsetDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneOffsetDateTime"><javatime:format value="${tickDefaultZoneOffsetDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneOffsetDateTime"><javatime:format value="${fixedChangeZoneOffsetDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneOffsetDateTime"><javatime:format value="${tickChangeZoneOffsetDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>OffsetTime (HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZoneOffsetTime"><javatime:format value="${fixedDefaultZoneOffsetTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneOffsetTime"><javatime:format value="${tickDefaultZoneOffsetTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneOffsetTime"><javatime:format value="${fixedChangeZoneOffsetTime}" pattern="HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneOffsetTime"><javatime:format value="${tickChangeZoneOffsetTime}" pattern="HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>ZonedDateTime (uuuu/MM/dd HH:mm:ss.SSS)</td>
        <td id="fixedDefaultZonedDateTime"><javatime:format value="${fixedDefaultZonedDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZonedDateTime"><javatime:format value="${tickDefaultZonedDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneZonedDateTime"><javatime:format value="${fixedChangeZoneZonedDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneZonedDateTime"><javatime:format value="${tickChangeZoneZonedDateTime}" pattern="uuuu/MM/dd HH:mm:ss.SSS" /></td>
    </tr>
    <tr>
        <td>JapaneseDate (uuuu/MM/dd)</td>
        <td id="fixedDefaultZoneJapaneseDate_uuuu"><javatime:format value="${fixedDefaultZoneJapaneseDate}" pattern="uuuu/MM/dd" /></td>
        <td id="tickDefaultZoneJapaneseDate_uuuu"><javatime:format value="${tickDefaultZoneJapaneseDate}" pattern="uuuu/MM/dd" /></td>
        <td id="fixedChangeZoneJapaneseDate_uuuu"><javatime:format value="${fixedChangeZoneJapaneseDate}" pattern="uuuu/MM/dd" /></td>
        <td id="tickChangeZoneJapaneseDate_uuuu"><javatime:format value="${tickChangeZoneJapaneseDate}" pattern="uuuu/MM/dd" /></td>
    </tr>
    <tr>
        <td>JapaneseDate (yyyy/MM/dd) - conversion error</td>
        <td id="fixedDefaultZoneJapaneseDate_Yyyy"><javatime:format value="${fixedDefaultZoneJapaneseDate}" pattern="yyyy/MM/dd" /></td>
        <td id="tickDefaultZoneJapaneseDate_yyyy"><javatime:format value="${tickDefaultZoneJapaneseDate}" pattern="yyyy/MM/dd" /></td>
        <td id="fixedChangeZoneJapaneseDate_yyyy"><javatime:format value="${fixedChangeZoneJapaneseDate}" pattern="yyyy/MM/dd" /></td>
        <td id="tickChangeZoneJapaneseDate_yyyy"><javatime:format value="${tickChangeZoneJapaneseDate}" pattern="yyyy/MM/dd" /></td>
    </tr>
    <tr>
        <td>JapaneseDate (和暦)</td>
        <td id="fixedDefaultZoneJapaneseDate_japaneseImperialYear"><javatime:format value="${fixedDefaultZoneJapaneseDate}" pattern="Gy年MM月dd日" /></td>
        <td id="tickDefaultZoneJapaneseDate_japaneseImperialYear"><javatime:format value="${tickDefaultZoneJapaneseDate}" pattern="Gy年MM月dd日" /></td>
        <td id="fixedChangeZoneJapaneseDate_japaneseImperialYear"><javatime:format value="${fixedChangeZoneJapaneseDate}" pattern="Gy年MM月dd日" /></td>
        <td id="tickChangeZoneJapaneseDate_japaneseImperialYear"><javatime:format value="${tickChangeZoneJapaneseDate}" pattern="Gy年MM月dd日" /></td>
    </tr>
    <tr>
        <td>LocalDateTime (西暦)</td>
        <td id="fixedDefaultZoneLocalDateTime_japaneseImperialYear"><javatime:format value="${fixedDefaultZoneLocalDateTime}" pattern="Gy年MM月dd日 HH:mm:ss.SSS" /></td>
        <td id="tickDefaultZoneLocalDateTime_japaneseImperialYear"><javatime:format value="${tickDefaultZoneLocalDateTime}" pattern="Gy年MM月dd日 HH:mm:ss.SSS" /></td>
        <td id="fixedChangeZoneLocalDateTime_japaneseImperialYear"><javatime:format value="${fixedChangeZoneLocalDateTime}" pattern="Gy年MM月dd日 HH:mm:ss.SSS" /></td>
        <td id="tickChangeZoneLocalDateTime_japaneseImperialYear"><javatime:format value="${tickChangeZoneLocalDateTime}" pattern="Gy年MM月dd日 HH:mm:ss.SSS" /></td>
    </tr>
</table>
