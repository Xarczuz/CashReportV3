package CashReport.controller.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void name() throws UnsupportedEncodingException {

//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("grant_type", "password");
//        params.add("client_id", "fooClientIdPassword");
//        params.add("username", username);
//        params.add("password", password);
//
//        ResultActions result
//                = mockMvc.perform(post("/oauth/token")
//                .params(params)
//                .with(httpBasic("fooClientIdPassword","secret"))
//                .accept("application/json;charset=UTF-8"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json;charset=UTF-8"));
//
//        String resultString = result.andReturn().getResponse().getContentAsString();
//
//        JacksonJsonParser jsonParser = new JacksonJsonParser();
//        jsonParser.parseMap(resultString).get("access_token").toString();
    }

    @Test
    @WithMockUser
    void getAllPerson() throws Exception {
        this.mockMvc.perform(get("/person")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    void addPerson() {
    }

    @Test
    void deletePerson() {
    }

    @Test
    void updatePerson() {
    }
}