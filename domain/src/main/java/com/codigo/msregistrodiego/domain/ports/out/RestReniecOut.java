package com.codigo.msregistrodiego.domain.ports.out;

import com.codigo.msregistrodiego.domain.aggregates.response.ResponseReniec;

public interface RestReniecOut {
    ResponseReniec getInfoReniec(String numDoc);
}
