package com.EEspindola.orquestador.controller;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //Ejecutar todos los test en una sola instancia
public class OrquestadorTest {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("****** Annotation BeforeAll");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("****** Annotation AfterAll");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("****** Annotation BeforeEach");
    }

    @AfterEach
    public void AfterEach(){
        System.out.println("****** Annotation AfterEach");
    }

    //test<SystemUnderTest>_<ConditionOrStateChange>_<ExpectedResult>
    @DisplayName("TestOrquestador-GetAll")
    @Test
    public void testOrquestadorGetAll_CuantoTodosLosParametrosSonLosEsperados_EsperamosObtenerUnaListaDeUsuarios() {
        //Arrange - Given

        //Act - When

        //Assert - Then

    }

}
