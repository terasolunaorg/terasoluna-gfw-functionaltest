package org.terasoluna.gfw.functionaltest.app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 * ブラウザ操作(WebDriverに対するロジック)を提供するクラス。
 */
public class WebDriverOperations {

    protected final WebDriver webDriver;

    protected long defaultTimeoutSecForImplicitlyWait = 5;

    public WebDriverOperations(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * 要素を見つけるまでの待機処理のデフォルトのタイムアウト値を設定する。
     * @param defaultTimeoutSecForImplicitlyWait 要素を見つけるまでの待機処理のデフォルトのタイムアウト値(秒)
     */
    public void setDefaultTimeoutForImplicitlyWait(
            long defaultTimeoutSecForImplicitlyWait) {
        this.defaultTimeoutSecForImplicitlyWait = defaultTimeoutSecForImplicitlyWait;
    }

    /**
     * 指定した要素が存在するかチェックする。
     * @param by 要素を探すための識別子
     * @return 指定した要素が存在する場合にtrueを返却する。
     */
    public boolean exists(By by) {
        webDriver.findElement(By.tagName("body"));
        setTimeoutForImplicitlyWait(0, TimeUnit.SECONDS);
        boolean existsElement = true;
        try {
            webDriver.findElement(by).getText();
        } catch (NoSuchElementException e) {
            existsElement = false;
        } finally {
            setDefaultTimeoutForImplicitlyWait();
        }
        return existsElement;
    }

    /**
     * 要素を見つけるまでの待機処理のタイムアウト値をデフォルト値に設定する。
     */
    public void setDefaultTimeoutForImplicitlyWait() {
        setTimeoutForImplicitlyWait(defaultTimeoutSecForImplicitlyWait,
                TimeUnit.SECONDS);
    }

    /**
     * 要素を見つけるまでの待機処理のタイムアウト値を設定する。
     */
    public void setTimeoutForImplicitlyWait(long timeout, TimeUnit timeUnit) {
        webDriver.manage().timeouts().implicitlyWait(timeout, timeUnit);
    }
}
