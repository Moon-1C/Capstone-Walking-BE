package com.walking.api.web.dto.request.point;

import com.walking.api.web.dto.request.validator.LatParam;
import com.walking.api.web.dto.request.validator.LngParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EndPointParam {

	/* 시작점 위도 */
	@LatParam private double endLat;

	/* 시작점 경도 */
	@LngParam private double endLng;
}
