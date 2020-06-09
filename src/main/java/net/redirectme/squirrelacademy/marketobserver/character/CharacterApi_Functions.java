package net.redirectme.squirrelacademy.marketobserver.character;

import net.redirectme.squirrelacademy.marketobserver.character.data.PublicInfo;
import net.redirectme.squirrelacademy.marketobserver.character.data.PublicInfoRepository;
import org.openapitools.client.model.GetCharactersCharacterIdOk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/***
 *
 * Get Public Information for Characters (like Corporation and and Alliance)
 * Changed to WebClient for testing purposes
 *
 */
@Service
public class CharacterApi_Functions {

    @Value("${esidatasource}")
    String esidatasource; // ="tranquility";

    @Autowired
    PublicInfoRepository publicInfoRepository;

//    @Autowired
//    WebClient webClient;

    @Value("${api_character_standings}")String api_character_standings;
    @Value("${api_character_publicInfo}") String api_character_publicInfo;

    private PublicInfo getPublicInfo(int character_id) throws Exception {
        String url = api_character_publicInfo.replace("{character_id}", String.valueOf(character_id));
//        GetCharactersCharacterIdOk info = webClient
//                .get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(GetCharactersCharacterIdOk.class)
//                .block()
//                ;
//        PublicInfo publicInfo = new PublicInfo(info, character_id);
//        return publicInfo;
        return null;
    }

    public PublicInfo getPublicInfoCached(int characterId) throws Exception {
        PublicInfo publicInfo = publicInfoRepository.findByCharacterid(characterId);
        if (publicInfo ==null) {
            publicInfo = getPublicInfo(characterId);
            publicInfoRepository.save(publicInfo);
        }
        return publicInfo;
    }


}