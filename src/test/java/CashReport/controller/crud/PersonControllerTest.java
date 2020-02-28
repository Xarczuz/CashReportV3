package CashReport.controller.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private String obtainAccessToken(String username, String password) throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("client_id", "perham");
        params.add("username", username);
        params.add("password", password);
        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic("perham", "1234"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
        String resultString = result.andReturn().getResponse().getContentAsString();
        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    void givenToken_whenGetAllSecureRequest_thenOk() throws Exception {
        String accessToken = obtainAccessToken("Ankan", "1234");
        this.mockMvc.perform(get("/person").header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void givenToken_whenGetSecureRequest_thenOk() throws Exception {
        String accessToken = obtainAccessToken("Ankan", "1234");
        this.mockMvc.perform(get("/person/3").header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void givenToken_whenGetWrongSecureRequest_thenNoContent() throws Exception {
        String accessToken = obtainAccessToken("Ankan", "1234");
        this.mockMvc.perform(get("/person/-465").header("Authorization", "Bearer " + accessToken))
                .andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    void givenToken_whenPostGetSecureRequest_thenOk() throws Exception {
        String accessToken = obtainAccessToken("Ankan", "1234");
        String personJson = "{\"roleid\":3,\"companyid\":0,\"firstname\":\"Kalleas\",\"lastname\":\"adAnka\",\"email\":\"fakalle@gmail.com\",\"phonenr\":\"1045234543\",\"password\":\"1234\",\"username\":\"a\",\"salt\":\"4456\"}";

        String location = mockMvc.perform(post("/person")
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .content(personJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getHeader("Location");

        mockMvc.perform(get(location)
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void deletePerson() {
    }

    @Test
    void updatePerson() {
    }
}