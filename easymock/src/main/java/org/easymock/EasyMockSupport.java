/**
 * Copyright 2001-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.easymock;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.easymock.internal.MockBuilder;

/**
 * Helper class to be used to keep tracks of mocks easily. See EasyMock
 * documentation and SupportTest sample.
 * <p>
 * Example of usage:
 * 
 * <pre>
 * public class SupportTest extends EasyMockSupport {
 *     &#064;Test
 *     public void test() {
 *         firstMock = createMock(A.class);
 *         secondMock = createMock(B.class);
 *         
 *         replayAll(); // put both mocks in replay mode
 *         
 *         // ... use mocks ..
 *         
 *         verifyAll(); // verify both mocks
 *     }
 * }
 * </pre>
 * 
 * @author Henri Tremblay
 */
public class EasyMockSupport {

    /** List of all controls created */
    protected final List<IMocksControl> controls = new ArrayList<IMocksControl>(5);

    /**
     * Creates a mock object that extends the given class, order checking is
     * enabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createStrictMock(final Class<T> toMock, final Method... mockedMethods) {
        return createStrictControl().createMock(toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * enabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createStrictMock(final String name, final Class<T> toMock, final Method... mockedMethods) {
        return createStrictControl().createMock(name, toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * enabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createStrictMock(final Class<T> toMock, final ConstructorArgs constructorArgs,
            final Method... mockedMethods) {
        return createStrictControl().createMock(toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * enabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createStrictMock(final String name, final Class<T> toMock,
            final ConstructorArgs constructorArgs, final Method... mockedMethods) {
        return createStrictControl().createMock(name, toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createMock(final Class<T> toMock, final Method... mockedMethods) {
        return createControl().createMock(toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createMock(final String name, final Class<T> toMock, final Method... mockedMethods) {
        return createControl().createMock(name, toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createMock(final Class<T> toMock, final ConstructorArgs constructorArgs,
            final Method... mockedMethods) {
        return createControl().createMock(toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createMock(final String name, final Class<T> toMock, final ConstructorArgs constructorArgs,
            final Method... mockedMethods) {
        return createControl().createMock(name, toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createNiceMock(final Class<T> toMock, final Method... mockedMethods) {
        return createNiceControl().createMock(toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createNiceMock(final String name, final Class<T> toMock, final Method... mockedMethods) {
        return createNiceControl().createMock(name, toMock, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createNiceMock(final Class<T> toMock, final ConstructorArgs constructorArgs,
            final Method... mockedMethods) {
        return createNiceControl().createMock(toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object that extends the given class, order checking is
     * disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param <T>
     *            the class that the mock object should extend.
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class that the mock object should extend.
     * @param constructorArgs
     *            constructor and parameters used to instantiate the mock.
     * @param mockedMethods
     *            methods that will be mocked, other methods will behave
     *            normally
     * @return the mock object.
     * 
     * @deprecated Use {@link #createMockBuilder(Class)} instead
     */
    @Deprecated
    public <T> T createNiceMock(final String name, final Class<T> toMock,
            final ConstructorArgs constructorArgs, final Method... mockedMethods) {
        return createNiceControl().createMock(name, toMock, constructorArgs, mockedMethods);
    }

    /**
     * Creates a mock object of the requested type that implements the given interface or extends
     * the given class
     * 
     * @param type
     *            the type of the mock to be created.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @param <T>
     *            the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is not a valid Java identifier.
     */
    public <T> T createMock(final MockType type, final Class<T> toMock) {
        return createControl(type).createMock(toMock);
    }

    /**
     * Creates a mock object of the requested type that implements the given interface or extends
     * the given class
     * 
     * @param name
     *            the name of the mock object.
     * @param type
     *            the type of the mock to be created.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @param <T>
     *            the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is not a valid Java identifier.
     */
    public <T> T createMock(final String name, final MockType type, final Class<T> toMock) {
        return createControl(type).createMock(name, toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is enabled by default.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public <T> T createStrictMock(final Class<T> toMock) {
        return createStrictControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is enabled by default.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @param <T>
     *            the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is not a valid Java identifier.
     */
    public <T> T createStrictMock(final String name, final Class<T> toMock) {
        return createStrictControl().createMock(name, toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public <T> T createMock(final Class<T> toMock) {
        return createControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is not a valid Java identifier.
     */
    public <T> T createMock(final String name, final Class<T> toMock) {
        return createControl().createMock(name, toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return the mock object.
     */
    public <T> T createNiceMock(final Class<T> toMock) {
        return createNiceControl().createMock(toMock);
    }

    /**
     * Creates a mock object that implements the given interface, order checking
     * is disabled by default, and the mock object will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @param name
     *            the name of the mock object.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @return the mock object.
     * @throws IllegalArgumentException
     *             if the name is not a valid Java identifier.
     */
    public <T> T createNiceMock(final String name, final Class<T> toMock) {
        return createNiceControl().createMock(name, toMock);
    }

    /**
     * Creates a control, order checking is enabled by default.
     * 
     * @return the control.
     */
    public IMocksControl createStrictControl() {
        final IMocksControl ctrl = EasyMock.createStrictControl();
        controls.add(ctrl);
        return ctrl;
    }

    /**
     * Create a mock builder allowing to create a partial mock for the given
     * class or interface.
     * 
     * @param <T>
     *            the interface that the mock object should implement.
     * @param toMock
     *            the class of the interface that the mock object should
     *            implement.
     * @return a mock builder to create a partial mock
     */
    public <T> IMockBuilder<T> createMockBuilder(final Class<T> toMock) {
        return new MockBuilder<T>(toMock, this);
    }

    /**
     * Creates a control of the given type.
     * 
     * @param type the mock type.
     * @return the control.
     * @since 3.2
     */
    public IMocksControl createControl(final MockType type) {
        final IMocksControl ctrl = EasyMock.createControl(type);
        controls.add(ctrl);
        return ctrl;
    }

    /**
     * Creates a control, order checking is disabled by default.
     * 
     * @return the control.
     */
    public IMocksControl createControl() {
        return createControl(MockType.DEFAULT);
    }

    /**
     * Creates a control, order checking is disabled by default, and the mock
     * objects created by this control will return <code>0</code>,
     * <code>null</code> or <code>false</code> for unexpected invocations.
     * 
     * @return the control.
     */
    public IMocksControl createNiceControl() {
        final IMocksControl ctrl = EasyMock.createNiceControl();
        controls.add(ctrl);
        return ctrl;
    }

    /**
     * Switches all registered mock objects (more exactly: the controls of the
     * mock objects) to replay mode. For details, see the EasyMock
     * documentation.
     */
    public void replayAll() {
        for (final IMocksControl c : controls) {
            c.replay();
        }
    }

    /**
     * Resets all registered mock objects (more exactly: the controls of the
     * mock objects). For details, see the EasyMock documentation.
     */
    public void resetAll() {
        for (final IMocksControl c : controls) {
            c.reset();
        }
    }

    /**
     * Verifies all registered mock objects (more exactly: the controls of the
     * mock objects).
     */
    public void verifyAll() {
        for (final IMocksControl c : controls) {
            c.verify();
        }
    }

    /**
     * Resets all registered mock objects (more exactly: the controls of the
     * mock objects) and turn them to a mock with nice behavior. For details,
     * see the EasyMock documentation.
     */
    public void resetAllToNice() {
        for (final IMocksControl c : controls) {
            c.resetToNice();
        }
    }

    /**
     * Resets all registered mock objects (more exactly: the controls of the
     * mock objects) and turn them to a mock with default behavior. For details,
     * see the EasyMock documentation.
     */
    public void resetAllToDefault() {
        for (final IMocksControl c : controls) {
            c.resetToDefault();
        }
    }

    /**
     * Resets all registered mock objects (more exactly: the controls of the
     * mock objects) and turn them to a mock with strict behavior. For details,
     * see the EasyMock documentation.
     */
    public void resetAllToStrict() {
        for (final IMocksControl c : controls) {
            c.resetToStrict();
        }
    }

    /**
     * Inject a mock to every attributes annotated with {@link Mock} on the class passed
     * in parameter
     * <p>
     * <b>Note:</b> If the parameter extends {@link EasyMockSupport}, the mocks will be created using it to allow
     * <code>replayAll/verifyAll</code> to work afterwards
     * @param obj the object on which to inject mocks
     * @since 3.2
     */
    public static void injectMocks(final Object obj) {
        Class<?> c = obj.getClass();
        while(c != Object.class) {
            injectMocksToClass(c, obj);
            c = c.getSuperclass();
        }
    }

    private static void injectMocksToClass(Class<?> clazz, Object obj) {
        final Field[] fields = clazz.getDeclaredFields();
        for (final Field f : fields) {
            final Mock annotation = f.getAnnotation(Mock.class);
            if (annotation == null) {
                continue;
            }
            final Class<?> type = f.getType();
            String name = annotation.name();
            if (name != null) {
                name = (name.length() == 0 ? null : name);
            }
            MockType mockType = annotation.type();
            Object o;
            if (obj instanceof EasyMockSupport) {
                o = ((EasyMockSupport) obj).createMock(name, mockType, type);
            }
            else {
                o = EasyMock.createMock(name, mockType, type);
            }
            f.setAccessible(true);
            try {
                f.set(obj, o);
            } catch (final IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
