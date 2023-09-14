package org.ttldtor.processexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.ttldtor.processexample.databinding.ActivityMainBinding
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        timer = Timer()

        timer.schedule(500, 2000) {
            runOnUiThread {
                binding.kernelProcessorTimeText.text =
                    getString(R.string.processor_time_ms, getKernelProcessorTime().toString())
                binding.userProcessorTimeText.text =
                    getString(R.string.processor_time_ms, getUserProcessorTime().toString())
                binding.totalProcessorTimeText.text =
                    getString(R.string.processor_time_ms, getTotalProcessorTime().toString())
                binding.workingSetSizeText.text =
                    getString(R.string.memory_size_kb, (getWorkingSetSize() / 1024).toString())
                binding.privateMemorySizeText.text =
                    getString(R.string.memory_size_kb, (getPrivateMemorySize() / 1024).toString())
            }
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    external fun getKernelProcessorTime(): Long
    external fun getUserProcessorTime(): Long
    external fun getTotalProcessorTime(): Long
    external fun getWorkingSetSize(): Long
    external fun getPrivateMemorySize(): Long

    companion object {
        // Used to load the 'processexample' library on application startup.
        init {
            System.loadLibrary("processexample")
        }
    }
}