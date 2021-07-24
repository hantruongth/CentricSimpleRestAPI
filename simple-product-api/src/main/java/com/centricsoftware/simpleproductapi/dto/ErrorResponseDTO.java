package com.centricsoftware.simpleproductapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author hantruong
 */

@Data
@Builder
public class ErrorResponseDTO {
    private String status;
    private String error;
    private String message;
}
