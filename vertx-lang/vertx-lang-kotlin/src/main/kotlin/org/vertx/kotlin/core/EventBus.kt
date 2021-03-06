/*
 * Copyright 2012 the original author or authors.
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

package org.vertx.kotlin.core

import org.vertx.java.core.eventbus.EventBus
import org.vertx.java.core.eventbus.Message
import org.vertx.java.core.json.JsonObject
import org.vertx.java.core.Handler

public fun <T> EventBus.registerLocalHandler(where: String? = null, localHandler: Message<T>.()->Any?) : String
    = (if(where != null)
        registerLocalHandler(where, handler<Message<T>>(localHandler))
       else
        registerLocalHandler(handler<Message<T>>(localHandler))
    )!!

public fun EventBus.post(where: String, msg: JsonObject, replyHandler: (Message<JsonObject?>)->Any?) : Unit
        = this.send(where, msg, handler(replyHandler))
