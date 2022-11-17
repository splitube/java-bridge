package bridge.generator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("주어진 길이만큼의 다리를 생성")
    @ValueSource(ints = {3, 5, 10, 15, 20})
    @ParameterizedTest
    void makeBridge(int bridgeSize) {
        //given
        final String[] status = {"U", "D"};
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        //when
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        //then
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(bridge).allSatisfy(areaStatus -> assertThat(status).contains(areaStatus));
    }
}