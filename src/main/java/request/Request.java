package request;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request implements Serializable {
    private final long serialVersionUID = 5L;
    private MappingType mappingType;
    private CommandType commandType;
    private String person;
    private String taskName;
    private TaskDTORequest taskDTORequest;


}
