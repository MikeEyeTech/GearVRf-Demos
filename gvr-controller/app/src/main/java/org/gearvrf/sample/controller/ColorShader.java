/* Copyright 2015 Samsung Electronics Co., LTD
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


package org.gearvrf.sample.controller;

import org.gearvrf.GVRContext;
import org.gearvrf.GVRShaderTemplate;

public class ColorShader extends GVRShaderTemplate
{
    private static final String VERTEX_SHADER = "in vec3 a_position;\n"
            + "@MATRIX_UNIFORMS\n"
            + "void main() {\n"
            + "  gl_Position = u_mvp * vec4(a_position, 1.0f);\n"
            + "}\n";

    private static final String FRAGMENT_SHADER = "precision mediump float;\n"
            + "@MATERIAL_UNIFORMS\n"
            + "out vec4 fragColor;\n"
            + "void main() {\n"
            + "  fragColor = u_color;\n"
            + "}\n";

    public ColorShader(GVRContext gvrContext)
    {
        super("float4 u_color", "", "float3 a_position", GLSLESVersion.V310);
        setSegment("FragmentTemplate", FRAGMENT_SHADER);
        setSegment("VertexTemplate", VERTEX_SHADER);
    }

}
