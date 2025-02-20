/*
 * Copyright 2019-2024 CloudNetService team & contributors
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

package eu.cloudnetservice.launcher.java22.dependency;

import lombok.NonNull;
import org.jetbrains.annotations.Nullable;

public record Dependency(
  @NonNull String repo,
  @NonNull String group,
  @NonNull String name,
  @NonNull String originalVersion,
  @NonNull String fullVersion,
  @NonNull String checksum,
  @Nullable String classifier
) {

  public @NonNull String normalizedGroup() {
    return this.group.replace('.', '/');
  }

  @Override
  public @NonNull String classifier() {
    return this.classifier == null ? "" : ("-" + this.classifier);
  }

  @Override
  public @NonNull String toString() {
    return String.format("%s %s %s%s", this.group, this.name, this.originalVersion, this.classifier());
  }
}
