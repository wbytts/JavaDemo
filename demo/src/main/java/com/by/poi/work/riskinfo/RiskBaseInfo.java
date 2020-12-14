package com.by.poi.work.riskinfo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskBaseInfo {
    private String id;
    private String responsible_dept_id;
    private String responsible_dept_name;
    private String business_process_name;
    private String business_process_num;
    private String key_link_name;
    private String key_link_num;
    private String risk_num;
    private String sgs_risk_num;
    private String rigth_post_type;
    private String risk_desc;
    private String impact_conseq;
    private String risk_type;
    private String risk_grade;
    private String edu_require;
    private String system_process;
    private String arti_auto;
    private String supervise;
    private String supervise_cycle;
    private String control;
    private String illegal_punish;
    private String case_base_index;
    private String version;
    private String is_newest;
    private String status;
    private String flowstatus;
    private String whydelete;
    private String is_common;
    private String risk_line_manager;
    private String performance;
    private String operate_dept_id;
    private String risk_extend1;
    private String old_risk_time;
    private String operate_risk_id;
    private String operate_reason;
    private String operate_content;
    private String risk_extend2;
    private String risk_extend3;
    private String risk_name;
    private String responsible_user_name;
    private String responsible_user_id;
    private String key_position;
    private String field_id;
}
