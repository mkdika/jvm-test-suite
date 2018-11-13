package com.mkdika.javamockitobdd;

import com.mkdika.javamockitobdd.model.Mail;
import com.mkdika.javamockitobdd.service.IncomingMailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

/**
 * Java Mockito BDD Demo
 *
 * <p>
 * This class is using Mockito BDD wrapper in order to fulfill
 * the "Given, When, Then" Structure.
 * </p>
 */
@RunWith(MockitoJUnitRunner.class)
public class EmailFilterTest {

    private EmailFilter emailFilter;

    @Mock
    private IncomingMailService incomingMailService;

    @Before
    public void init() {
        emailFilter = new EmailFilter();
    }

    @Test
    public void given_notNull_email_when_called_filter_then_return_result() {

        // Given
        final Mail mail = new Mail("sales@super-store.com",
                "mkdika@gmail.com",
                "End year sale for you!",
                "Bla..bla..bla");
        given(incomingMailService.getIncomingMail())
                .willReturn(mail);

        // When
        final Boolean result = emailFilter.checkIncomingMail(incomingMailService.getIncomingMail());

        // Then
        then(result)
                .as("Check that sender address contain suspicious promotion phrase")
                .isNotNull()
                .isEqualTo(Boolean.TRUE);
    }

}
