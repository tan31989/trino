/*
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
package io.trino.json.ir;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.trino.spi.type.Type;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

public class IrNamedValueVariable
        extends IrPathNode
{
    private final int index;

    @JsonCreator
    public IrNamedValueVariable(@JsonProperty("index") int index, @JsonProperty("type") Optional<Type> type)
    {
        super(type);
        checkArgument(index >= 0, "parameter index is negative");
        this.index = index;
    }

    @Override
    protected <R, C> R accept(IrJsonPathVisitor<R, C> visitor, C context)
    {
        return visitor.visitIrNamedValueVariable(this, context);
    }

    @JsonProperty
    public int getIndex()
    {
        return index;
    }
}
