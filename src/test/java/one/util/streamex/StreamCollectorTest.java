/*
 * Copyright 2015, 2016 Tagir Valeev
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
package one.util.streamex;

import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author Tagir Valeev
 */
public class StreamCollectorTest {
    @Test
    public void testBasics() {
        Map<Integer, List<String>> map = IntStreamEx.range(100).boxed().collect(
            c -> c.groupingBy(x -> x / 10, c1 -> c1.flatMap(x -> StreamEx.of(x, x)).map(x -> "[" + x + "]").limit(3)
                    .toList()));
    }
}
