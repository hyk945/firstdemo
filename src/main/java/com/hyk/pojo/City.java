package com.hyk.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Description:
 * Author: ykhuang
 * Version: 1.0
 * Create Date Time: 2019/4/4 9:24.
 * Update Date Time:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 1808340591917738185L;

    private String name;
    private String codeF;
    private BigDecimal id;
}
