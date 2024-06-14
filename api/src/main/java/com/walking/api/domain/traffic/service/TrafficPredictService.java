package com.walking.api.domain.traffic.service;

import com.walking.api.domain.traffic.service.dto.CurrentDetailsResponse;
import com.walking.api.domain.traffic.service.dto.TrafficPredictServiceRequest;
import com.walking.api.domain.traffic.service.dto.TrafficPredictServiceResponse;
import com.walking.api.domain.traffic.service.predictor.TrafficCurrentDetailPredictor;
import com.walking.api.domain.traffic.service.predictor.TrafficCyclePredictor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** 신호등의 현재 잔여 시간, 현재 색상, 각 색상별 사이클을 예측한 결과를 리턴합니다. */
@Service
@RequiredArgsConstructor
@Slf4j
public class TrafficPredictService {

	private final TrafficCyclePredictor trafficCyclePredictor;
	private final TrafficCurrentDetailPredictor trafficCurrentDetailPredictor;

	@Transactional(readOnly = true)
	public TrafficPredictServiceResponse execute(TrafficPredictServiceRequest requestDto) {
		final List<Long> trafficIds = requestDto.getTrafficIds();

		CurrentDetailsResponse currentTrafficDetails =
				trafficCurrentDetailPredictor.execute(trafficCyclePredictor, trafficIds);
		return TrafficPredictServiceResponse.builder()
				.predictedData(currentTrafficDetails.getCurrentDetails())
				.build();
	}

	public TrafficPredictServiceResponse execute(List<Long> trafficIds) {
		return execute(TrafficPredictServiceRequest.builder().trafficIds(trafficIds).build());
	}
}
