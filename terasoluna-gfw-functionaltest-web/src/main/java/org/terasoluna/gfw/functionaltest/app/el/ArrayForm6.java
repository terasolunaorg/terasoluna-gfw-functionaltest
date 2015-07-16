/*
 * Copyright (C) 2013-2015 terasoluna.org
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
package org.terasoluna.gfw.functionaltest.app.el;

public class ArrayForm6 {
    private int[] array1;

    private double[] array2;

    private byte[] array3;

    private String[] array4;

    private ArrayFormItem6 item;

    public ArrayForm6() {
    }

    public ArrayForm6(int[] array1, double[] array2, byte[] array3,
            String[] array4, ArrayFormItem6 item) {
        this.array1 = array1;
        this.array2 = array2;
        this.array3 = array3;
        this.array4 = array4;
        this.item = item;
    }

    public int[] getArray1() {
        return array1;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public double[] getArray2() {
        return array2;
    }

    public void setArray2(double[] array2) {
        this.array2 = array2;
    }

    public byte[] getArray3() {
        return array3;
    }

    public void setArray3(byte[] array3) {
        this.array3 = array3;
    }

    public String[] getArray4() {
        return array4;
    }

    public void setArray4(String[] array4) {
        this.array4 = array4;
    }

    public ArrayFormItem6 getItem() {
        return item;
    }

    public void setItem(ArrayFormItem6 item) {
        this.item = item;
    }
}
