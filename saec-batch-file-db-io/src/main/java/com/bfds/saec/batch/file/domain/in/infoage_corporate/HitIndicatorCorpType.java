package com.bfds.saec.batch.file.domain.in.infoage_corporate;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "hitIndicatorCorpType")
@XmlEnum
public enum HitIndicatorCorpType {
    Y,
    N;

    public String value() {
        return name();
    }

    public static HitIndicatorCorpType fromValue(String v) {
        return valueOf(v);
    }
}
