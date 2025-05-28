package org.terasoluna.gfw.functionaltest.app;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class FunctionalTestSupportExtension implements TestWatcher, AfterTestExecutionCallback {
    @Override
    public void testSuccessful(ExtensionContext context) {
        FunctionTestSupport instance = (FunctionTestSupport) context.getRequiredTestInstance();
        instance.onSucceeded();
        instance.succeededEvidence();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        FunctionTestSupport instance = (FunctionTestSupport) context.getRequiredTestInstance();
        instance.onFailed(cause);
        instance.failedEvidence();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        FunctionTestSupport instance = (FunctionTestSupport) context.getRequiredTestInstance();
        instance.onFinished();
    }

}
