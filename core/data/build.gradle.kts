/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.jacoco)
    alias(libs.plugins.nowinandroid.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.google.samples.apps.nowinandroid.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true // 在运行单元测试时，将 Android 资源（如字符串、颜色、尺寸等）包含在测试环境中。这样，你就可以在单元测试中访问这些资源，就像在应用的正常运行环境中一样
            isReturnDefaultValues = true // 当 Android 框架方法在单元测试环境中被调用时，如果这些方法没有被模拟（mock），那么它们将返回默认值，而不是抛出异常。例如，如果你在单元测试中调用了一个返回 Context 的方法，但你并没有模拟这个方法，那么这个方法将返回一个默认的 Context 对象，而不是抛出 Stub! 异常。这可以使得在单元测试中更容易地测试那些依赖于 Android 框架方法的代码。
        }
    }
}

dependencies {
    api(projects.core.common)
    api(projects.core.database)
    api(projects.core.datastore)
    api(projects.core.network)

    implementation(projects.core.analytics)
    implementation(projects.core.notifications)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
    testImplementation(projects.core.datastoreTest)
    testImplementation(projects.core.testing)
}
