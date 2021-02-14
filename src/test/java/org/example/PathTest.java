package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class PathTest {

  private static class Bean {
    Path path;
  }

  @Test
  void test(@TempDir final Path tempDir) {
    Bean bean = new Bean();
    bean.path = tempDir.resolve("file.txt");
    Bean bean2 = new Bean();
    bean2.path = tempDir.resolve("file.txt");;

    assertThat(bean).usingRecursiveComparison()
                    .isEqualTo(bean2);
  }

  @Test
  void test_with_equals(@TempDir final Path tempDir) {
    Bean bean = new Bean();
    bean.path = tempDir.resolve("file.txt");
    Bean bean2 = new Bean();
    bean2.path = tempDir.resolve("file.txt");;

    assertThat(bean).usingRecursiveComparison()
                    .withEqualsForType(Path::equals, Path.class)
                    .isEqualTo(bean2);
  }

}
