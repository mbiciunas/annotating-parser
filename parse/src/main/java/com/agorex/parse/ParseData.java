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
package com.agorex.parse;

import com.agorex.parse.annotation.AnnotationState;
import com.agorex.parse.error.ErrorData;
import com.agorex.parse.token.ConfigurationData;
import com.agorex.parse.token.SourceData;
import com.agorex.parse.token.TokenData;


/**
 * @author mbiciunas
 *
 */
public final class ParseData {

   private final transient ConfigurationData configurationData;
   private final transient SourceData sourceData = new SourceData();
   private final transient TokenData tokenData = new TokenData(100);
   private final transient ErrorData errorData = new ErrorData(10);
   private final transient AnnotationState annotationState = new AnnotationState(10);


   /**
    * @param configurationData object defining how to annotate the source.
    */
   public ParseData(final ConfigurationData configurationData) {
      this.configurationData = configurationData;
   }


   /**
    * @param source information to be parsed
    */
   public void initialize(final String source) {
      sourceData.initialize(source);
      tokenData.initialize();
      errorData.initialize();
      annotationState.initialize(configurationData);
   }


   /**
    * @return the source being parsed
    */
   public SourceData getSource() { return sourceData; }


   /**
    * @return tokens generated
    */
   public TokenData getToken() { return tokenData; }


   /**
    * @return errors generated
    */
   public ErrorData getError() { return errorData; }


   /**
    * @return stack used during source processing
    */
   public AnnotationState getStackAnnotation() { return annotationState; }


   /**
    * @return configuration object used to annotate source
    */
   public ConfigurationData getConfigurationData() { return configurationData; }
}
