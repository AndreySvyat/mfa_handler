package ru.svyat.bg.hndlr;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.groups.responses.GetByIdObjectLegacyResponse;

import java.util.List;

public class App {
	private static final Integer APP_ID = 51474665;
	private static final String CLIENT_SECRET = "DJEnlrwTPnG5cKAtMk1K";
	private static final String ACCESS_TOKEN = "ec555e8bec555e8bec555e8be4ef442e62eec55ec555e8b8f3af31a29d3f54ccd711b22";

	public static void main(String[] args) throws Exception {

		TransportClient transportClient = new HttpTransportClient();
		VkApiClient vk = new VkApiClient(transportClient);

		ServiceActor srv = new ServiceActor(APP_ID, CLIENT_SECRET, ACCESS_TOKEN);

		List<GetByIdObjectLegacyResponse> ids = vk.groups()
				.getByIdObjectLegacy(srv)
				.groupId("mafshow")
				.execute();
		ids.stream()
				.map(GetByIdObjectLegacyResponse::getId)
				.forEach(System.out::println);
    }
}
