//package com.example.walletsystem.user.presentation.controller;
//
//import com.example.walletsystem.user.application.dto.CreateUserDTO;
//import com.example.walletsystem.user.application.dto.UserResponseDTO;
//import com.example.walletsystem.user.application.exception.UserAlreadyExistException;
//import com.example.walletsystem.user.application.service.UserService;
//import com.example.walletsystem.wallet.application.dto.WalletResponseDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.UUID;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(UserController.class)
//class UserControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private UserService userService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void shouldCreateUserSuccessfully() throws Exception {
//        // Arrange
//        String email = "test@example.com";
//        Long id = 1L;
//        UserResponseDTO responseDTO = new UserResponseDTO(id, UUID.randomUUID());
//        Mockito.when(userService.createUser(email)).thenReturn(responseDTO);
//
//        CreateUserDTO request = new CreateUserDTO(email);
//
//        // Act & Assert
//        mockMvc.perform(post("/api/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.data.id").value(id));
//    }
//
//    @Test
//    void shouldReturnConflictWhenUserAlreadyExists() throws Exception {
//        // Arrange
//        String email = "exists@example.com";
//        Mockito.when(userService.createUser(email))
//                .thenThrow(new UserAlreadyExistException(email));
//
//        CreateUserDTO request = new CreateUserDTO(email);
//
//        // Act & Assert
//        mockMvc.perform(post("/api/v1/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(request)))
//                .andExpect(status().isConflict());
//    }
//}
