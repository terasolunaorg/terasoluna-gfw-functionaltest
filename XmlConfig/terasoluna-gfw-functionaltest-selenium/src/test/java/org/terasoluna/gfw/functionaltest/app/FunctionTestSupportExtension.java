/*
 * Copyright(c) 2026 NTT DATA Group Corporation.
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
package org.terasoluna.gfw.functionaltest.app;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class FunctionTestSupportExtension implements TestWatcher, AfterTestExecutionCallback {

    private final FunctionTestSupport testSupport;

    public FunctionTestSupportExtension(FunctionTestSupport testSupport) {
        this.testSupport = testSupport;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testSupport.onSucceeded();
        testSupport.succeededEvidence();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testSupport.onFailed(cause);
        testSupport.failedEvidence();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        testSupport.onFinished();
    }
}
