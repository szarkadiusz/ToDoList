package com.Core;
import org.junit.Test;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;
public class SerwissTest {
    private static final String WELCOME = "hello";
    private static final String FALLBACK_ID_WELCOME = "hello";
    private Serwiss SUT = new Serwiss();

    @Test
    public void test_prepGreeting_nullname_returns_fallbackVslue() throws Exception {
        //given
        var mockRepository = alwaysReturningHelloRepository();
        var SUT = new Serwiss(mockRepository);
        // when
        var result = SUT.prepGreeting(null, "-1");
        //then
        assertThat(WELCOME + " " + Serwiss.FALLBACK_NAME).isEqualTo(result);
    }
    @Test
    public void test_prepGreeting_returns_greetingWithName() throws Exception {
        //given
        var SUT = new Serwiss();
        var name = "test";
        //when
        var result = SUT.prepGreeting(name, "-1");
        //then
        assertThat(WELCOME + " " + name).isEqualTo(result);
    }
    @Test
    public void test_prepGreeting_nullLang_greetingWithNameWithFallBackIdLang() throws Exception {
        //given
        var mockRepository = fallbackLangIdRepository();
        var SUT = new Serwiss(mockRepository);
        //when
        var result = SUT.prepGreeting(null, null);
        //then
        assertThat(FALLBACK_ID_WELCOME + " " + Serwiss.FALLBACK_NAME).isEqualTo(result);

    }

    @Test
    public void test_prepGreeting_nonExsistingLang_greetingWithNameWithFallBackIdLang() throws Exception {
        //given
        var mockRepository = new LangRepository(){
            @Override
            Optional<Lang> findById(Integer id) {
                return Optional.empty();
            }
        };
        var SUT = new Serwiss(mockRepository);
        //when
        var result = SUT.prepGreeting(null, "-1");
        //then
        assertThat(Serwiss.FALLBACK_LANG.getWelcomeMessage() + " " + Serwiss.FALLBACK_NAME).isEqualTo(result);

    }

    @Test
    public void test_prepGreeting_textLang_greetingWithNameWithFallBackIdLang() throws Exception {
        //given
        var mockRepository = fallbackLangIdRepository();
        var SUT = new Serwiss(mockRepository);
        //when
        var result = SUT.prepGreeting(null, "abc");
        //then
        assertThat(FALLBACK_ID_WELCOME + " " + Serwiss.FALLBACK_NAME).isEqualTo(result);

    }

    private LangRepository fallbackLangIdRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Integer id) {
                if (id.equals(Serwiss.FALLBACK_LANG.getId())) {
                    return Optional.of(new Lang(null, FALLBACK_ID_WELCOME, null));
                }
                return Optional.empty();
            }
        };
    }

    private LangRepository alwaysReturningHelloRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Integer id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }
}