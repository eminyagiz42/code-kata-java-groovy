package curiousity.librarykata.lombok;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentModel {

    private final int id;
    private final String name;
}
