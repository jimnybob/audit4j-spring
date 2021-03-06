/*
 * Copyright (c) 2014-2016 Janith Bandara, This source is a part of
 * Audit4j - An open source auditing framework.
 * http://audit4j.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.audit4j.integration.spring;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.audit4j.core.AuditManager;

/**
 * The Class AuditAspect.
 * <p>
 * Configuration:
 * </p>
 * 
 * <pre>
 * {@code
 * <aop:config>
 *     <aop:aspect id="audit" ref="auditAspect">
 *         <aop:pointcut id="packages"
 *             expression="execution(* com.xyz.myapp.service.*.*(..))" />
 *         <aop:before pointcut-ref="packages" method="audit" />
 *     </aop:aspect>
 * </aop:config>
 * 
 * <bean id="auditAspect" class="org.audit4j.integration.spring.AuditAspect"/>
 * }
 * </pre>
 * 
 * @author <a href="mailto:janith3000@gmail.com">Janith Bandara</a>
 * 
 * @deprecated
 */
@Deprecated
public class AuditAspectOld {

    /**
     * Audit.
     * 
     * @param jointPoint
     *            the pjp
     * 
     * @throws Throwable
     *             the throwable
     */
    public void audit(final JoinPoint jointPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
        Method method = methodSignature.getMethod();
        AuditManager.getInstance().audit(jointPoint.getTarget().getClass(), method, jointPoint.getArgs());
    }
}
