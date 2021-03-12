package top.durandal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (LiveRecording)实体类
 *
 * @author makejava
 * @since 2020-10-05 20:23:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveRecording implements Serializable {
    /**
     * 直播记录ID
     */
    private Integer liveRecordingId;
    /**
     * 直播间编号
     */
    private String liveId;
    /**
     * 直播时长
     */
    private String liveTime;
    /**
     * 直播会看(录播)
     */
    private String liveVideo;

}