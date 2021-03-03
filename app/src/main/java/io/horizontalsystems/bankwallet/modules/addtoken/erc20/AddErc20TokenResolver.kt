package io.horizontalsystems.bankwallet.modules.addtoken.erc20

import io.horizontalsystems.bankwallet.modules.addtoken.IAddEvmTokenResolver
import io.horizontalsystems.coinkit.models.Coin
import io.horizontalsystems.coinkit.models.CoinType

class AddErc20TokenResolver(
        testMode: Boolean,
        etherscanApiKey: String
) : IAddEvmTokenResolver {

    override val apiUrl = if (testMode) "https://api-ropsten.etherscan.io/" else "https://api.etherscan.io/"

    override val explorerKey = etherscanApiKey

    override fun doesCoinMatchReference(coin: Coin, reference: String): Boolean {
        return (coin.type as? CoinType.Erc20)?.address.equals(reference, ignoreCase = true)
    }

    override fun coinType(address: String): CoinType {
        return CoinType.Erc20(address)
    }

}
