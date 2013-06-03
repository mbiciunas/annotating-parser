/*
 * Copyright 2013 Mark Biciunas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorex.parse.search.annotation;


/**
 * @author mbiciunas
 *
 */
final class ResultSingleAnnotation {

   private final transient int annotation;
   private final transient int token;


   /**
    * @param annotation value of annotation.
    * @param token index of token.
    */
   ResultSingleAnnotation(final int annotation, final int token) {
      this.annotation = annotation;
      this.token = token;
   }


   /**
    * @return value of annotation.
    */
   public int getAnnotation() { return annotation; }


   /**
    * @return index of token.
    */
   public int getToken() { return token; }
}
