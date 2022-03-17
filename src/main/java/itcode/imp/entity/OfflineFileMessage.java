package itcode.imp.entity;

import itcode.imp.enumeration.DataType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imp
 * @date 2022/3/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfflineFileMessage {

    private String sessionId;

    private DataType dataType;

    private String delimiter;

    private List<String> cosPaths;

    private String importDate;

    @Override
    public String toString() {
        return "OfflineFileMessage{" +
            "sessionId='" + sessionId + '\'' +
            ", dataType=" + dataType +
            ", delimiter='" + delimiter + '\'' +
            ", cosPaths=" + cosPaths +
            ", importDate=" + importDate +
            '}';
    }
}
